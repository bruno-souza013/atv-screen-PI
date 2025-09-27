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


}