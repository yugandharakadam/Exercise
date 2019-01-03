package com.jpa;

/*@SpringBootTest(classes = Exercise1Application.class)
@WebAppConfiguration
@EnableJpaRepositories(basePackages="com.jpa")
public class Exercise1ApplicationTests extends AbstractTestNGSpringContextTests{
	
	private static final Logger log = LoggerFactory.getLogger(Exercise1ApplicationTests.class);
	public static void main(String[] args) {
		SpringApplication.run(Exercise1ApplicationTests.class, args);
	}
	
	@Test
	public void contextLoads() {
	}
	
	/*@Transactional
	public Employee addEmployee(){
		Address ad = new Address("Pune", "Wakad", 411060L);
		Department department = new Department("R&D", ad);
		Role role = new Role("Devloper");
		
		departmentRepository.save(department);
		roleRepository.save(role);
		
		Project project = new Project("Mindsphere", new Date(), new Date());
		projectRepository.save(project);
		
		Employee emp = new Employee("Yuga", "Kadam", "ykadam","SD", ad, department, Arrays.asList(role), Arrays.asList(project));
		emp = employeeRepository.save(emp);
		return emp;
	}*/


