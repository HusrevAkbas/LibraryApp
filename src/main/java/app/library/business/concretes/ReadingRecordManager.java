package app.library.business.concretes;

import app.library.business.abstracts.ReadingRecordService;
import app.library.dataAccess.abstracts.ReadingRecordRepository;
import app.library.entities.concretes.ReadingRecord;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import app.library.utilities.results.SuccessDataResult;
import app.library.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingRecordManager implements ReadingRecordService {
    ReadingRecordRepository recordRepository;
    @Autowired
    public ReadingRecordManager(ReadingRecordRepository recordRepository){
        this.recordRepository = recordRepository;
    }
    @Override
    public DataResult<List<ReadingRecord>> findAllReadingRecords() {
        return new SuccessDataResult<>(this.recordRepository.findAll(),"All records listed");
    }

    @Override
    public DataResult<ReadingRecord> findReadingRecordById(Long id) {
        return new SuccessDataResult<>(this.recordRepository.findById(id).get(),"Record found");
    }

    @Override
    public Result delete(Long id) {
        this.recordRepository.deleteById(id);
        return new SuccessResult("Record deleted");
    }

    @Override
    public Result add(ReadingRecord readingRecord) {
        this.recordRepository.save(readingRecord);
        return new SuccessResult("Record added");
    }

    @Override
    public Result update(ReadingRecord readingRecord) {
        this.recordRepository.save(readingRecord);
        return new SuccessResult("Record updated");
    }
}
