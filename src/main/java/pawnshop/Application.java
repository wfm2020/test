package pawnshop;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableProcessApplication
@EntityScan(basePackages = {"pawnshop.entity"})
@EnableJpaRepositories("pawnshop.repository")
@ComponentScan({
        "pawnshop.controller",
        "pawnshop.service"
})
public class Application {

    @Autowired
    private RuntimeService runtimeService;

    @EventListener
    private void processPostDeploy(PostDeployEvent event) {
        runtimeService.startProcessInstanceByKey("Process_12x2cxl");
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
