package com.example.screenpi.repository
import com.example.screenpi.model.*
class DataRepository private constructor() {

    companion object {
        @Volatile
        private var INSTANCE: DataRepository? = null

        fun getInstance(): DataRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: DataRepository().also { INSTANCE = it }
            }
        }
    }
    

    // Dados do projeto
    fun getProjectInfo(): Project {
        return Project(
            name = "Sistema de Filtragem de Áudio para TPAC",
            description = "Um software para filtragem e processamento de áudio, desenvolvido para auxiliar " +
                    "indivíduos com Transtorno do Processamento Auditivo Central (TPAC). O sistema utiliza " +
                    "Inteligência Artificial para reduzir ruídos externos, realçar a fala, e oferece funcionalidades " +
                    "como retrocesso de áudio e ajuste de velocidade de reprodução sem alterar o tom. " +
                    "Integra aplicativo móvel com backend em Flask e modelo de deep learning em PyTorch.",
            objective = "Reduzir o estresse sonoro e melhorar a compreensão em crianças com TPAC em ambientes de aprendizado",
            imageUrl = "https://picsum.photos/800/400"
        )
    }

 // Lista de ODSs relacionadas ao projeto
    fun getRelatedSDGs(): List<SDG> {
        return listOf(
            SDG(
                number = 3,
                title = "Saúde e Bem-Estar",
                description = "Assegurar uma vida saudável e promover o bem-estar para todos, em todas as idades. " +
                        "Nosso projeto contribui diretamente para a meta 3 dos ODS da ONU, desenvolvendo uma " +
                        "solução tecnológica que melhora a qualidade de vida de pessoas com TPAC, promovendo " +
                        "saúde auditiva e bem-estar através de um ambiente sonoro mais claro e controlado.",
                imageUrl = "https://images.unsplash.com/photo-1559757148-5c350d0d3c56?w=400&h=200&fit=crop",
                isRelatedToProject = true
            ),
            SDG(
                number = 4,
                title = "Educação de Qualidade",
                description = "Assegurar a educação inclusiva e equitativa de qualidade. " +
                        "O software facilita o aprendizado de crianças com TPAC em ambientes educacionais, " +
                        "melhorando a compreensão e concentração durante atividades pedagógicas, promovendo " +
                        "inclusão educacional e melhores oportunidades de aprendizado.",
                imageUrl = "https://images.unsplash.com/photo-1503676260728-1c00da094a0b?w=400&h=200&fit=crop",
                isRelatedToProject = true
            ),
            SDG(
                number = 10,
                title = "Redução das Desigualdades",
                description = "Reduzir as desigualdades dentro dos países e entre eles. " +
                        "Democratizamos o acesso à tecnologia assistiva para pessoas com dificuldades auditivas, " +
                        "oferecendo uma solução adaptativa e acessível que reduz barreiras e promove inclusão " +
                        "social, acadêmica e profissional.",
                imageUrl = "https://images.unsplash.com/photo-1573496359142-b8d87734a5a2?w=400&h=200&fit=crop",
                isRelatedToProject = true
            )
        )
    }
    // Lista da equipe do projeto
    fun getTeamMembers(): List<TeamMemberBase> {
        return listOf(
            Developer(
                name = "Bruno Lopes de Souza",
                imageUrl = "https://avatars.githubusercontent.com/u/148831208?s=200&v=4",
                specialization = "Frontend/Mobile - Kotlin",
                githubUrl = "https://github.com/bruno-souza013"
            ),
            Developer(
                name = "Daniel Augusto Mandira",
                imageUrl = "https://avatars.githubusercontent.com/u/105872910?s=200&v=4",
                specialization = "Backend/APIs - Flask Python",
                githubUrl = "https://github.com/DanielMandira"
            ),
            Developer(
                name = "João Pedro Faustino Cordeiro",
                imageUrl = "https://avatars.githubusercontent.com/u/115119412?s=200&v=4",
                specialization = "Frontend/Mobile - Kotlin",
                githubUrl = "https://github.com/jpfcordeiro"
            ),
            Developer(
                name = "Leonardo Wicher L. Ferreira",
                imageUrl = "https://avatars.githubusercontent.com/u/128431361?s=200&v=4",
                specialization = "DevOps/Infraestrutura - Docker",
                githubUrl = "https://github.com/wchrLeonardo"
            ),
            DbManager(
                name = "Marcelo Augusto Aguiar da Cruz",
                imageUrl = "https://avatars.githubusercontent.com/u/123131698?s=200&v=4",
                databaseArea = "Desenvolvimento de IA",
                githubUrl = "https://github.com/marcelitos1v9"
            )
        )
    }

}