package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BorrowingRecordCreateDTO;
import softuni.exam.models.dto.BorrowingRecordWrapperDTO;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.BookRepository;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.util.ValidationUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static softuni.exam.constants.Paths.BORROWING_RECORDS_PATH;
import static softuni.exam.constants.Messages.*;
import static softuni.exam.models.entity.enums.Genre.SCIENCE_FICTION;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {
    private final BookRepository bookRepository;
    private final BorrowingRecordRepository borrowingRecordRepository;
    private final LibraryMemberRepository libraryMemberRepository;
    private final ModelMapper mapper;
    private final ValidationUtils validator;
    private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    public BorrowingRecordsServiceImpl(BookRepository bookRepository,
                                       BorrowingRecordRepository borrowingRecordRepository,
                                       LibraryMemberRepository libraryMemberRepository, ModelMapper mapper, ValidationUtils validator) {
        this.bookRepository = bookRepository;
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.libraryMemberRepository = libraryMemberRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.borrowingRecordRepository.count() > 0;
    }

    @Override
    public String readBorrowingRecordsFromFile() throws IOException {
        return Files.readString(Path.of(BORROWING_RECORDS_PATH));
    }

    @Override
    public String importBorrowingRecords() throws IOException, JAXBException {
        StringBuilder out = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(BORROWING_RECORDS_PATH))) {
            JAXBContext context = JAXBContext.newInstance(BorrowingRecordWrapperDTO.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            BorrowingRecordWrapperDTO borrowingRecordWrapperDTO = (BorrowingRecordWrapperDTO) unmarshaller.unmarshal(reader);

            for (BorrowingRecordCreateDTO recordDTO : borrowingRecordWrapperDTO.getBorrowingRecords()) {
                boolean isValid = this.validator.isValid(recordDTO);

                Book book = this.bookRepository
                        .findBookByTitle(recordDTO.getBook().getTitle())
                        .orElse(null);

                LibraryMember member = this.libraryMemberRepository
                        .findById(Long.valueOf(recordDTO.getMember().getId()))
                        .orElse(null);

                if (book == null || member == null) {
                    isValid = false;
                }

                if (isValid) {
                    out.append(String.format(BORROWING_RECORD_IMPORTED,
                            recordDTO.getBook().getTitle(),
                            recordDTO.getBorrowDate()));

                    LocalDate borrowDate = LocalDate.parse(recordDTO.getBorrowDate(), DATE_FORMATTER);
                    LocalDate returnDate = LocalDate.parse(recordDTO.getReturnDate(), DATE_FORMATTER);

                    BorrowingRecord record = this.mapper.map(recordDTO, BorrowingRecord.class);
                    record.setBook(book);
                    record.setMember(member);
                    record.setBorrowDate(borrowDate);
                    record.setReturnDate(returnDate);

                    this.borrowingRecordRepository.saveAndFlush(record);
                } else {
                    out.append(INVALID_BORROWING_RECORD);
                }

                out.append(System.lineSeparator());
            }

            out.append(System.lineSeparator());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return out.toString().trim();
    }

    @Override
    public String exportBorrowingRecords() {
        StringBuilder out = new StringBuilder();

        List<BorrowingRecord> records = this.borrowingRecordRepository
                .findBorrowingRecordsByBook_GenreIsAndBorrowDateBefore(
                        SCIENCE_FICTION,
                        LocalDate.parse("2021-09-10", DATE_FORMATTER))
                .stream()
                .sorted(Comparator.comparing(BorrowingRecord::getBorrowDate).reversed())
                .collect(Collectors.toList());

        for (BorrowingRecord record : records) {
            out.append(String.format(RECORDS_EXPORT,
                    record.getBook().getTitle(),
                    record.getBook().getAuthor(),
                    record.getBorrowDate(),
                    record.getMember().getFirstName(),
                    record.getMember().getLastName()));
        }

        return out.toString().trim();
    }
}
