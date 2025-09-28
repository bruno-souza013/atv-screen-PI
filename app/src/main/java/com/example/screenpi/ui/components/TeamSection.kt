package com.fatec.calmwave_landing.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.screenpi.model.DbManager
import com.example.screenpi.model.Developer
import com.example.screenpi.model.TeamMemberBase
import com.example.screenpi.model.*

@Composable
fun TeamSection(
    teamMembers: List<TeamMemberBase>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        // Título da seção
        Text(
            text = "Nossa Equipe",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Text(
            text = "Conheça a equipe multidisciplinar por trás do sistema de filtragem de áudio para TPAC:",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // Lista de membros da equipe usando Column em vez de LazyColumn para evitar nested scrolling
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            teamMembers.forEach { member ->
                TeamMemberCard(teamMember = member)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamMemberCard(
    teamMember: TeamMemberBase,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(teamMember.imageUrl)
                    .crossfade(true)
                    .memoryCacheKey("team_${teamMember.name.hashCode()}")
                    .diskCacheKey("team_${teamMember.name.hashCode()}")
                    .allowHardware(false) // Melhora compatibilidade
                    .build(),
                contentDescription = "Foto de ${teamMember.name}",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop,
                error = painterResource(android.R.drawable.ic_menu_report_image),
                placeholder = painterResource(android.R.drawable.ic_menu_gallery)
            )
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = teamMember.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                
                Text(
                    text = teamMember.getRole(),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 4.dp)
                )
                
                Text(
                    text = teamMember.getDescription(),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
                
                when (teamMember) {
                    is Developer -> {
                        if (teamMember.hasGithub()) {
                            Text(
                                text = "GitHub: ${teamMember.githubUrl}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }
                    is DbManager -> {
                        if (teamMember.hasGithub()) {
                            Text(
                                text = "GitHub: ${teamMember.githubUrl}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }
                }
            }
            
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = when (teamMember) {
                            is Developer -> MaterialTheme.colorScheme.primary
                            is DbManager -> MaterialTheme.colorScheme.outline
                            else -> Color.Gray
                        },
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = when (teamMember) {
                        is Developer -> "💻"
                        is DbManager -> "\uD83E\uDD16"
                        else -> "👤"
                    },
                    fontSize = 20.sp
                )
            }
        }
    }
}
