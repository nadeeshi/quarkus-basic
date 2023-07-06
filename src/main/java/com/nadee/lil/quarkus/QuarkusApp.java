package com.nadee.lil.quarkus;

import com.nadee.lil.quarkus.data.entity.Service;
import com.nadee.lil.quarkus.data.repository.ServiceRepository;
import com.nadee.lil.quarkus.util.FizzBuzzExecutor;
import com.nadee.lil.quarkus.util.GreetingUtil;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.enterprise.context.control.ActivateRequestContext;

import java.util.List;

/**
 * @QuarkusMain - this is going to give us a command line version of our application
 *
 * Run Quarkus, it will run it, everything is good to go. A couple things to note here.
 *   First of all, if you use java-jar, you need to use the jar file in the Quarkus app directory within the target directory. It will be called Quarkus run jar.
 *   Secondly, you will lose the ability to use dev mode when doing this.
 *
 *   If you want to run from the command line and use dev mode I suggest you use the packaged Maven script MVNW with the Quarkus run command.
 *   So you will use ./MVNW space Quarkus:run to execute that in dev mode.
 *
 *   You also can package this as a jar and do a Java.jar command.
 *   To do that, you're going to do a Maven Clean package that will spit out a jar in the target directory and then you can do a java-jar of that jar file and it will run.
 *
 *   I'm just going to use built into my IDE. So we'll let this start up and it's going to bring out a bunch of dependencies and then it's going to execute.
 */

@QuarkusMain
public class QuarkusApp implements QuarkusApplication {

    GreetingUtil greetingUtil;

    FizzBuzzExecutor fizzBuzzExecutor;

    private final ServiceRepository serviceRepository;

    public QuarkusApp(GreetingUtil greetingUtil, FizzBuzzExecutor fizzBuzzExecutor, ServiceRepository serviceRepository) {
        super();
        this.greetingUtil = greetingUtil;
        this.fizzBuzzExecutor = fizzBuzzExecutor;
        this.serviceRepository = serviceRepository;
    }

    @Override
    @ActivateRequestContext
    public int run(String... args) throws Exception {
        System.out.println(this.greetingUtil.getGreeting());
        this.fizzBuzzExecutor.execute();

        List<Service> services = this.serviceRepository.getAllServices();
        services.forEach(System.out::println);

        return 0;
    }
}
