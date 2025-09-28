package com.example.screenpi.model

abstract class TeamMemberBase(
    open val name: String,
    open val imageUrl: String
) {
    abstract fun getRole(): String
    abstract fun getDescription(): String

    // Método comum para todos os membros
    fun getDisplayName(): String {
        return "$name - ${getRole()}"
    }
}

data class Developer(
    override val name: String,
    override val imageUrl: String,
    val specialization: String,
    val githubUrl: String = ""
) : TeamMemberBase(name, imageUrl) {

    override fun getRole(): String = "Desenvolvedor"

    override fun getDescription(): String {
        return "Desenvolvedor especializado em $specialization"
    }

    fun hasGithub(): Boolean = githubUrl.isNotBlank()
}

data class DbManager(
    override val name: String,
    override val imageUrl: String,
    val databaseArea: String,
    val githubUrl: String = ""
) : TeamMemberBase(name, imageUrl) {

    override fun getRole(): String = "Especialista em IA"

    override fun getDescription(): String {
        return "Especialista em $databaseArea"
    }

    fun hasGithub(): Boolean = githubUrl.isNotBlank()
}
