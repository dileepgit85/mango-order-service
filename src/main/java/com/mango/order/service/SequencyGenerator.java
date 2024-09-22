package com.mango.order.service;

import com.mango.order.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.stereotype.Service;




@Service
public class SequencyGenerator {
    @Autowired
    MongoOperations mongoOperations;
    public int generateNextOrderId() {
        Sequence counter = mongoOperations.findAndModify(Query.query(where("_id").is("orderId")),
                new Update().inc("seq", 1), FindAndModifyOptions.options().returnNew(true).upsert(true), Sequence.class);

        return counter.getSeq();
    }
}
