package com.example.demo

import com.example.demo.repository.UserRepository
import com.example.demo.data.User
import org.assertj.core.api.Assertions.assertThat
import org.jooq.DSLContext
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jooq.JooqTest
import kotlin.test.assertNotNull

@JooqTest
class UserJooqRepositoryTest: AbstractContainerBaseTest() {

	@Autowired
	lateinit var dslContext: DSLContext

	lateinit var userRepository: UserRepository

	@BeforeEach
	fun setUp() {
		userRepository = UserRepository(dslContext)
	}

	@Test
	fun itShouldFetchUsers() {
		val users = userRepository.getAllUsers()
		users.forEach {
			println(it)
		}
		assertThat(users).isNotEmpty
	}

	@Test
	fun itShouldCreateUsers() {
		val userCount = userRepository.getAllUsers().size
		val email = "baggio1103@mail.ru"
		val user = User(12, "baggio", email)
		userRepository.createUser(user)
		assertThat(userCount + 1).isEqualTo(userRepository.getAllUsers().size)
		val userByEmail = userRepository.getUserByEmail(email)
		assertNotNull(userByEmail)
		assertThat(userByEmail.email).isEqualTo(email)
		println(userByEmail)
	}

}