package pawnshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawnshop.dto.DeliveryDataDTO;
import pawnshop.dto.PawnDataDTO;
import pawnshop.entity.Customer;
import pawnshop.entity.DeliveryData;
import pawnshop.entity.PawnedItem;
import pawnshop.repository.CustomerRepository;
import pawnshop.repository.DeliveryDataRepository;
import pawnshop.repository.PawnedItemRepository;

import java.util.logging.Logger;

@Service
public class PawnShopService {

    private final Logger LOGGER = Logger.getLogger(PawnShopService.class.getName());

    @Autowired
    private PawnedItemRepository pawnedItemRepository;

    @Autowired
    private DeliveryDataRepository deliveryDataRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public void create(PawnDataDTO data) {

        PawnedItem pawnedItem = new PawnedItem();
        pawnedItem.setItemName(data.getItemName());
        pawnedItem.setMaterial(data.getMaterial());
        pawnedItem.setWeight(data.getWeight());

        pawnedItemRepository.save(pawnedItem);

        Customer customer = customerRepository.findByEmail(data.getEmail());

        if(customer == null){
            customer = new Customer();
            customer.setFirstName(data.getFirstName());
            customer.setLastName(data.getLastName());
            customer.setBirthDate(data.getBirthDate());
            customer.setEmail(data.getEmail());
            customer.setPhoneNumber(data.getPhoneNumber());
        }
        customer.addPawnedItem(pawnedItem);
        customerRepository.save(customer);
    }

    public PawnedItem getPawnItemById(Long id) {
        return pawnedItemRepository.findById(id).get();
    }

    public PawnedItem updatePawnedItemPrice(PawnedItem data) {
        PawnedItem pawnedItem = getPawnItemById(data.getId());
        pawnedItem.setPrice(data.getPrice());
        return pawnedItemRepository.save(pawnedItem);
    }

    public PawnedItem updatePawnedItemPayment(PawnedItem data) {
        PawnedItem pawnedItem = getPawnItemById(data.getId());
        pawnedItem.setPayed(data.isPayed());
        return pawnedItemRepository.save(pawnedItem);
    }

    public DeliveryData create(DeliveryDataDTO data){
        DeliveryData deliveryData = new DeliveryData();
        deliveryData.setDateTime(data.getDateTime());

        return deliveryDataRepository.save(deliveryData);
    }

    public DeliveryData getDeliveryData(Long id) {
        return deliveryDataRepository.findById(id).get();
    }

}
