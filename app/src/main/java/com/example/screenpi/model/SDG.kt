package com.example.screenpi.model

/**
 * Classe que representa um Objetivo de Desenvolvimento Sustentável (ODS)
 * Aplicando conceitos de POO: Encapsulamento
 */
data class SDG( // Sustainable Development Goal
    val number: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val isRelatedToProject: Boolean = false
) {
    // Método para obter identificação completa da ODS
    fun getFullTitle(): String {
        return "ODS $number: $title"
    }
    
    // Método para verificar relevância
    fun isRelevant(): Boolean {
        return isRelatedToProject && description.isNotBlank()
    }
    
    // Método para obter cor baseada no número da ODS
    fun getThemeColor(): String {
        return when (number) {
            1 -> "#E5243B" // Erradicação da Pobreza
            2 -> "#DDA63A" // Fome Zero
            3 -> "#4C9F38" // Saúde e Bem-Estar
            4 -> "#C5192D" // Educação de Qualidade
            5 -> "#FF3A21" // Igualdade de Gênero
            6 -> "#26BDE2" // Água Potável e Saneamento
            7 -> "#FCC30B" // Energia Limpa e Acessível
            8 -> "#A21942" // Trabalho Decente e Crescimento Econômico
            9 -> "#FD6925" // Indústria, Inovação e Infraestrutura
            10 -> "#DD1367" // Redução das Desigualdades
            11 -> "#FD9D24" // Cidades e Comunidades Sustentáveis
            12 -> "#BF8B2E" // Consumo e Produção Responsáveis
            13 -> "#3F7E44" // Ação Contra a Mudança Global do Clima
            14 -> "#0A97D9" // Vida na Água
            15 -> "#56C02B" // Vida Terrestre
            16 -> "#00689D" // Paz, Justiça e Instituições Eficazes
            17 -> "#19486A" // Parcerias e Meios de Implementação
            else -> "#6B6B6B" // Cor padrão
        }
    }
}
