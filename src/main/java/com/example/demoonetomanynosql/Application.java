package com.example.demoonetomanynosql;

import com.example.demoonetomanynosql.log.Host;
import com.example.demoonetomanynosql.log.HostRepository;
import com.example.demoonetomanynosql.log.LogMessage;
import com.example.demoonetomanynosql.log.LogMessageRepository;
import com.example.demoonetomanynosql.person.Address;
import com.example.demoonetomanynosql.person.Person;
import com.example.demoonetomanynosql.person.PersonRepository;
import com.example.demoonetomanynosql.product.Part;
import com.example.demoonetomanynosql.product.PartRepository;
import com.example.demoonetomanynosql.product.Product;
import com.example.demoonetomanynosql.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class Application implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PartRepository partRepository;

	@Autowired
	private HostRepository hostRepository;

	@Autowired
	private LogMessageRepository logMessageRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/**
		 * One-to-Few
		 * Person x Addresses
		 */
		this.personRepository.deleteAll();
		Arrays.asList(
				Person.builder()
					.name("Kate Monster")
					.ssn("123-456-7890")
					.addresses(Arrays.asList(
							Address.builder()
									.street("123 Sesame St")
									.city("Anytown")
									.cc("USA")
									.build(),
							Address.builder()
									.street("123 Avenue Q")
									.city("New York")
									.cc("USA")
									.build()
					)).build()
		).forEach(this.personRepository::save);

		/**
		 * One-to-Many
		 * Product x Parts
		 */
		this.partRepository.deleteAll();
		this.productRepository.deleteAll();
		List<Part> parts = Arrays.asList(
				Part.builder()
						.partNo(UUID.randomUUID().toString())
						.name(UUID.randomUUID().toString())
						.qty(10)
						.cost(10.00)
						.price(100.00)
						.build(),
				Part.builder()
						.partNo(UUID.randomUUID().toString())
						.name(UUID.randomUUID().toString())
						.qty(20)
						.cost(20.00)
						.price(200.00)
						.build(),
				Part.builder()
						.partNo(UUID.randomUUID().toString())
						.name(UUID.randomUUID().toString())
						.qty(30)
						.cost(30.00)
						.price(300.00)
						.build()
		);
		this.partRepository.saveAll(parts);

		Product product = Product.builder()
				.name("left-handed smoke shifter")
				.manufacturer("Acme Corp")
				.catalogNumber(1234)
				.parts(parts)
				.build();
		this.productRepository.save(product);
		this.productRepository.findAll().forEach(System.out::println);

		/**
		 * One-to-Squillions
		 * Host x Log
		 */
		Host host = this.hostRepository.save(Host.builder().name("goofy.example.com").ipaddr("127.66.66.66").build());
		Arrays.asList(
				LogMessage.builder().time(Calendar.getInstance().getTime()).message("cpu is on fire!").host(host).build(),
				LogMessage.builder().time(Calendar.getInstance().getTime()).message("server not working!").host(host).build(),
				LogMessage.builder().time(Calendar.getInstance().getTime()).message("problem with file system").host(host).build()
		).forEach(this.logMessageRepository::save);
		this.logMessageRepository.findByHost(host).forEach(System.out::println);

	}
}
