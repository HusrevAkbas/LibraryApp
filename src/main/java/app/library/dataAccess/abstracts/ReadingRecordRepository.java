package app.library.dataAccess.abstracts;

import app.library.entities.concretes.ReadingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingRecordRepository extends JpaRepository<ReadingRecord,Long> {
}
