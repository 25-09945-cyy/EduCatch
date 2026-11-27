package com.missedclass.system.service;

import com.missedclass.system.model.ClassRecord;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassRecordService {

    //temporary storage
    private final List<ClassRecord>
            records =
            new ArrayList<>();

    private int nextId = 1;

    //add rec
    public void addRecord(
            ClassRecord record) {

        record.setId(nextId++);

        records.add(record);
    }

    //view rec
    public List<ClassRecord>
    getAllRecords() {

        return records;
    }

    //find id
    public ClassRecord
    getRecordById(int id) {

        for (
                ClassRecord record
                : records
        ) {

            if (
                    record.getId()
                            == id
            ) {

                return record;
            }
        }

        return null;
    }

    //del rec
    public void deleteRecord(
            int id) {

        records.removeIf(
                record ->
                        record.getId()
                                == id
        );
    }

    //upd rec
    public void updateRecord(
            ClassRecord updatedRecord) {

        for (
                int i = 0;
                i < records.size();
                i++
        ) {

            if (
                    records.get(i)
                            .getId()
                            ==
                            updatedRecord.getId()
            ) {

                records.set(
                        i,
                        updatedRecord
                );

                break;
            }
        }
    }

   //sirts sub
    public List<ClassRecord>
    searchBySubject(
            String keyword) {

        List<ClassRecord>
                matches =
                new ArrayList<>();

        for (
                ClassRecord record
                : records
        ) {

            if (
                    record.getSubject()
                            .toLowerCase()
                            .contains(
                                    keyword
                                            .toLowerCase()
                            )
            ) {

                matches.add(record);
            }
        }

        return matches;
    }
}