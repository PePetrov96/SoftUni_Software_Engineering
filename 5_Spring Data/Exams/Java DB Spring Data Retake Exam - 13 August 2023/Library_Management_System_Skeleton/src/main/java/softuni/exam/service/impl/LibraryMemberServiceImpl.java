package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.LibraryMemberCreateDTO;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.Paths.LIBRARY_MEMBERS_PATH;
import static softuni.exam.constants.Messages.*;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {
    private final LibraryMemberRepository libraryMemberRepository;
    private final Gson gson;
    private final ValidationUtils validator;
    private final ModelMapper mapper;

    @Autowired
    public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository, Gson gson,
                                    ValidationUtils validator, ModelMapper mapper) {
        this.libraryMemberRepository = libraryMemberRepository;
        this.gson = gson;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.libraryMemberRepository.count() > 0;
    }

    @Override
    public String readLibraryMembersFileContent() throws IOException {
        return Files.readString(Path.of(LIBRARY_MEMBERS_PATH));
    }

    @Override
    public String importLibraryMembers() throws IOException {
        StringBuilder out = new StringBuilder();

        LibraryMemberCreateDTO[] memberDTOs = this.gson.fromJson(readLibraryMembersFileContent(), LibraryMemberCreateDTO[].class);

        for (LibraryMemberCreateDTO memberDTO : memberDTOs) {
            boolean isValid = this.validator.isValid(memberDTO);

            if (memberExists(memberDTO)) {
                isValid = false;
            }

            if (isValid) {
                out.append(String.format(LIBRARY_MEMBER_IMPORTED,
                        memberDTO.getFirstName(),
                        memberDTO.getLastName()));

                LibraryMember member = this.mapper.map(memberDTO, LibraryMember.class);

                this.libraryMemberRepository.saveAndFlush(member);
            } else {
                out.append(INVALID_LIBRARY_MEMBER);
            }

            out.append(System.lineSeparator());

        }

        return out.toString().trim();
    }

    private boolean memberExists(LibraryMemberCreateDTO memberDTO) {
        return this.libraryMemberRepository
                .findLibraryMemberByPhoneNumber(memberDTO.getPhoneNumber())
                .isPresent();
    }
}
