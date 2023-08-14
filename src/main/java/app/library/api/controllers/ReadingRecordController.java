package app.library.api.controllers;

import app.library.business.abstracts.ReadingRecordService;
import app.library.entities.concretes.ReadingRecord;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reading-record")
@CrossOrigin(origins = "*")
public class ReadingRecordController {
    @Autowired
    ReadingRecordService recordService;

    @GetMapping("/all")
    public DataResult<List<ReadingRecord>> getAllRecords(){
        return this.recordService.findAllReadingRecords();
    }
    @GetMapping("/{id}")
    public DataResult<ReadingRecord> getRecordById(@PathVariable("id") Long id){
        return this.recordService.findReadingRecordById(id);
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteRecordById(@PathVariable("id") Long id){
        return this.recordService.delete(id);
    }
    @PostMapping("/add")
    public Result addRecord(@RequestBody ReadingRecord record){
        return this.recordService.add(record);
    }
    @PutMapping("/update")
    public Result updateRecord(@RequestBody ReadingRecord record){
        return this.recordService.update(record);
    }
}
