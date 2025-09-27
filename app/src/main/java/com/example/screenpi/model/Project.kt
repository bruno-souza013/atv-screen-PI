package com.example.screenpi.model

data class Project(
    val name: String,
    val description: String,
    val objective: String,
    val imageUrl: String
) {
    // Método para obter resumo do projeto
    fun getSummary(): String {
        return "Projeto: $name - $objective"
    }

    // Método para validar se o projeto tem informações completas
    fun isComplete(): Boolean {
        return name.isNotBlank() &&
                description.isNotBlank() &&
                objective.isNotBlank() &&
                imageUrl.isNotBlank()
    }
}
