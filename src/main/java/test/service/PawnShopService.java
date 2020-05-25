package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.dto.PawnCustomerDTO;
import test.entity.Customer;
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

    public void create(PawnCustomerDTO data) {

        PawnData pawn = new PawnData();
        pawn.setName(data.getName());
        pawn.setMaterial(data.getMaterial());
        pawn.setWeight(data.getWeight());
        pawn.setKarats(data.getKarats());

        Customer customer = new Customer();

        customer.setFirstName(data.getFirstName());
        customer.setLastName(data.getLastName());
        customer.setBirthDate(data.getBirthDate());
        customer.setEmail(data.getEmail());
        customer.setPhoneNumber(data.getPhoneNumber());

        customerRepository.save(customer);
        pawnDataRepository.save(pawn);

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
