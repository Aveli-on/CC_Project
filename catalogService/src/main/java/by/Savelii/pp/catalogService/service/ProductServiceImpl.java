/*
package by.Savelii.pp.catalogService.service;

import by.Savelii.pp.catalogService.service.dto.CreateProductDto;
import by.Savelii.pp.core.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class ProductServiceImpl implements ProductService {
    private KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public ProductServiceImpl(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createProduct() throws ExecutionException, InterruptedException {
        //TODO save DB


        SendResult<String, ProductCreatedEvent> result = kafkaTemplate
                .send("product-created-events-topic", productId, productCreatedEvent).get();

        LOGGER.info("Partition: {}", result.getRecordMetadata().partition());
        LOGGER.info("Topic: {}", result.getRecordMetadata().topic());
        LOGGER.info("Ofset: {}", result.getRecordMetadata().offset());

        */
/*future.whenComplete((result,exception)->{
            if(exception!=null){
                LOGGER.error("failed to send message: {}",exception.getMessage());
            }
            else   {
                LOGGER.info("Message sent succesfully: {}",result.getRecordMetadata());
            }
        });*//*

        */
/*future.join();*//*


        LOGGER.info("Return: {}", productId);
        return productId;
    }
}
*/
