package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.enums.Genre;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
    Optional<BorrowingRecord> findBorrowingRecordById(Long id);
    @Query("SELECT br FROM BorrowingRecord br WHERE br.book.genre = :genre AND br.borrowDate < :date")
    Set<BorrowingRecord> findBorrowingRecordsByGenreAndBorrowDateBefore(@Param("genre") Genre genre, @Param("date") LocalDate date);

    Set<BorrowingRecord> findBorrowingRecordsByBook_GenreIsAndBorrowDateBefore(Genre genre, LocalDate date);
    Set<BorrowingRecord> findAllByBorrowDateBeforeAndBook_Genre(LocalDate date, Genre genre);
}
