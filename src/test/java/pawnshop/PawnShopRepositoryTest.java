package pawnshop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pawnshop.entity.Customer;
import pawnshop.repository.CustomerRepository;
import pawnshop.repository.DeliveryDataRepository;
import pawnshop.repository.PawnDataRepository;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PawnShopRepositoryTest {

    @Autowired
    private PawnDataRepository pawnDataRepository;

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
}
