package app.library.business.abstracts;

import app.library.entities.concretes.ReadingRecord;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;

import java.util.List;

public interface ReadingRecordService {
    public DataResult<List<ReadingRecord>> findAllReadingRecords();
    public DataResult<ReadingRecord> findReadingRecordById(Long id);
    public Result delete(Long id);
    public Result add(ReadingRecord book);
    public Result update(ReadingRecord book);
}
