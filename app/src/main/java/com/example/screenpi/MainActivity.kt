package com.example.screenpi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.screenpi.repository.DataRepository
import com.example.screenpi.ui.theme.*
import com.example.screenpi.ui.components.*
import com.fatec.calmwave_landing.ui.components.TeamSection
import  com.example.screenpi.ui.components.FooterSection

/**
 * Activity principal da aplicação
 * Aplicando conceitos de POO: Composição e Injeção de Dependências
 */
class MainActivity : ComponentActivity() {

    // Instância do repositório de dados
    private val dataRepository = DataRepository.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalmwavelandingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LandingPageContent(repository = dataRepository)
                }
            }
        }
    }
}

/**
 * Conteúdo principal da landing page
 */
@Composable
fun LandingPageContent(
    repository: DataRepository,
    modifier: Modifier = Modifier
) {
    // Carregamento dos dados usando o repositório
    val projectInfo = remember { repository.getProjectInfo() }
    val sdgsList = remember { repository.getRelatedSDGs() }
    val teamMembers = remember { repository.getTeamMembers() }

    // Layout principal usando LazyColumn
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        // Header da aplicação
        item(key = "header") {
            HeaderSection()
        }
        //Seção da projeto
        item(key = "project") {
            ProjectSection(project = projectInfo)
        }
        // Seção dos ODSs
        item(key = "sdgs") {
            SDGSection(sdgs = sdgsList)
        }

        // Seção da equipe
        item(key = "team") {
            TeamSection(teamMembers = teamMembers)
        }
        // Seção do rodapé
        item(key = "footer") {
            FooterSection(
                modifier = Modifier.padding(top = 32.dp)
            )
        }
    }
}

/**
 * Preview da landing page
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LandingPagePreview() {
    CalmwavelandingTheme {
        LandingPageContent(repository = DataRepository.getInstance())
    }
}