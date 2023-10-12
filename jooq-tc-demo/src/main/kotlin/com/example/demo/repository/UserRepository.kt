package com.example.demo.repository
import com.example.demo.tables.Users.USERS
import com.example.demo.data.User
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
   private val dslContext: DSLContext
) {

    fun getAllUsers(): List<User> {
        val result = dslContext.selectFrom(USERS)
        println(result)
        return dslContext.selectFrom(USERS).map { User(it.id, it.name, it.email) }
    }

    fun createUser(user: User) {
        val newRecord = dslContext.newRecord(USERS, user)
        newRecord.store()
    }

    fun getUserByEmail(email: String): User? {
        return dslContext.select(USERS.ID, USERS.NAME, USERS.EMAIL)
            .from(USERS)
            .where(USERS.EMAIL.containsIgnoreCase(email))
            .fetchOne { User(it.value1(), it.value2(), it.value3()) }
    }

}