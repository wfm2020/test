package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.entity.DeliveryData;
import test.entity.PawnData;
import test.repository.CustomerRepository;
import test.repository.DeliveryDataRepository;
import test.repository.PawnDataRepository;

import java.util.logging.Logger;

@Component
public class PawnShopService {

    private final Logger LOGGER = Logger.getLogger(PawnShopService.class.getName());

    @Autowired
    private PawnDataRepository pawnDataRepository;

    @Autowired
    private DeliveryDataRepository deliveryDataRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public PawnData create(PawnData data) {
        return pawnDataRepository.save(data);
    }

    public DeliveryData createDelivery(DeliveryData data) {
        return deliveryDataRepository.save(data);
    }

    public PawnData getPawn(Long id) {
        return pawnDataRepository.findById(id).get();
    }

    public DeliveryData getDeliveryData(Long id) {
        return deliveryDataRepository.findById(id).get();
    }

    public PawnData update(PawnData data) {
        PawnData saved = getPawn(data.getId());
        saved.setName(data.getName());
        return pawnDataRepository.save(saved);
    }

}
