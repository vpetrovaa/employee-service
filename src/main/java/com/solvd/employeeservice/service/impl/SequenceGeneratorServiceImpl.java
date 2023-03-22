package com.solvd.employeeservice.service.impl;

import com.solvd.employeeservice.domain.DatabaseSequence;
import com.solvd.employeeservice.service.SequenceGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@RequiredArgsConstructor
public class SequenceGeneratorServiceImpl implements SequenceGeneratorService {

    private final ReactiveMongoOperations mongoOperations;

    @Override
    public Long generateSequence(String sequenceName) {
        Mono<DatabaseSequence> counter = mongoOperations.findAndModify(query(where("_id").is(sequenceName)),
                new Update().inc("sequence",1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.block().getSequence() : 1;
    }

}
