//package com.qa.MapTests;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.qa.domain.Account;
//import com.qa.repository.AccountMapRepository;
//import com.qa.repository.AccountRepository;
//
//import util.JSONUtil;
//
//public class AccountServiceTest {
//	private JSONUtil jsonUtil = new JSONUtil();
//
//	private AccountMapRepository amr;
//	private final String ACCOUNT_JSON_1 = "{'ID':1,'ACCOUNTNUMBER':'ADC123','FIRSTNAME':'SCOOT','LASTNAME':'PACINO'}";
//	private final String ACCOUNT_JSON_2 = "{'ID':1,'ACCOUNTNUMBER':'ADC123','FIRSTNAME':'CHAD','LASTNAME':'THUNDER'}";
//
//	private final Account ACCOUNT_1 = new Account(1, "ABC123", "AVA", "GARDNER");
////	private final Account ACCOUNT_2 = new Account(2, "XYZ456", "GENE", "KELLY");
////	private final Account ACCOUNT_3 = new Account(3, "DEF987", "MARLON", "BRANDO");
////	private final Account ACCOUNT_4 = new Account(4, "GHI654", "HEDY", "LAMARR");
//
//	@Before
//	public void setup() {
//		this.amr = new AccountMapRepository();
//	}
//
//	@Test
//	public void getAllAccountsTest() {
//		assertEquals("{}", amr.getAllAccounts());
//	}
//
//	@Test
//	public void addAccountTest() {
//		assertEquals("Failed to add account", AccountRepository.SUCCESS, this.amr.createAccount(this.ACCOUNT_JSON_1));
//	}
//
//	@Test
//	public void updateAccountTest() {
//		this.amr.createAccount(this.ACCOUNT_JSON_1);
//		assertEquals("Failed to update account", AccountRepository.FAILURE,
//				this.amr.updateAccount(1, this.ACCOUNT_JSON_2));
//	}
//
//	@Test
//	public void getCountForFirstNamesInAccount() {
//		String stringToTest = "{\"id\":1,\"accountNumber\":\"ABC123\",\"firstName\":\"AVA\",\"lastName\":\"GARDNER\"}";
//		Account testAccount = jsonUtil.getObjectForJSON(stringToTest, Account.class);
//		assertEquals(ACCOUNT_1.getFirstName(), testAccount.getFirstName());
//	}
//	
//	//// @Test
//	//// public void removeAccountTest() {
//	//// fail("TODO");
//	//// }
//	
//	//// @Test
//	//// public void remove2AccountsTest() {
//	//// fail("TODO");
//	//// }
//	
//	//// @Test
//	//// public void remove2AccountTestAnd1ThatDoesntExist() {
//	//// fail("TODO");
//	//// }
//	
//	//// @Test
//	//// public void jsonStringToAccountConversionTest() {
//	//// // testing JSONUtil
//	//// fail("TODO");
//	//// }
//	
//	//// @Test
//	//// public void accountConversionToJSONTest() {
//	//// //testing JSONUtil
//	//// fail("TODO");
//	//// }
//	
//	//// @Test
//	//// public void getCountForFirstNamesInAccountWhenZeroOccurances() {
//	//// //For a later piece of functionality
//	//// fail("TODO");
//	//// }
//	
//
//	//// @Test
//	//// public void getCountForFirstNamesInAccountWhenTwo() {
//	//// //For a later piece of functionality
//	//// fail("TODO");
//	//// }
//	
//}
