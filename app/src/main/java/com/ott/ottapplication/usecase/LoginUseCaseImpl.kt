package com.ott.ottapplication.usecase

class LoginUseCaseImpl(private val loginRepository: LoginRepository) : LoginUseCase {

    override fun login(userName: String, password: String) {
        loginRepository.fetchLogin(userName, password)
    }
}