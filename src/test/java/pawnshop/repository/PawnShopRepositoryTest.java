package pawnshop.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pawnshop.Application;
import pawnshop.entity.Customer;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PawnShopRepositoryTest {

    @Autowired
    private PawnedItemRepository pawnedItemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DeliveryDataRepository deliveryDataRepository;

    @Test
    public void givenCustomer_whenSave_thenGetOk() {
        Customer customer = new Customer("Max", "Mustermann", "max.mustermann@mail.at", LocalDate.of(1990, 1, 1), "123456");
        customer = customerRepository.save(customer);
        Customer savedCustomer = customerRepository.findById(customer.getId()).get();
        assertNotNull(savedCustomer);
        assertEquals("Max", savedCustomer.getFirstName());
    }

    @Test
    public void givenCustomer_whenFindByEmail_thenGetOk() {
        Customer customer = new Customer("Maxim", "Mustermann", "maxim.mustermann@mail.com",
                LocalDate.of(1990, 1, 1), "123456");
        customer = customerRepository.save(customer);
        Customer savedCustomer = customerRepository.findByEmail(customer.getEmail());
        assertNotNull(savedCustomer);
        assertEquals("Maxim", savedCustomer.getFirstName());
    }

    @Test
    public void givenCustomer_whenSaveExistingEmail_thenGetNotOk() {
        Customer customer = new Customer("Maxim", "Mustermann", "maxim.mustermann@mail.com",
                LocalDate.of(1990, 1, 1), "123456");
        customerRepository.save(customer);
        Customer duplicateCustomer = new Customer("Maxima", "Musterfrau", "maxim.mustermann@mail.com",
                LocalDate.of(1991, 2, 2), "012345");
        customerRepository.save(customer);
        List<Customer> customers = customerRepository.findAll();
        assertEquals(1, customers.size());
    }
}
