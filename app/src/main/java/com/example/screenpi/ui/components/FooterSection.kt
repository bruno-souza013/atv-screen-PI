package com.example.screenpi.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info // Exemplo de ícone
import androidx.compose.material.icons.filled.Share // Exemplo de ícone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.screenpi.ui.theme.CalmwavelandingTheme
import java.util.Calendar

@Composable
fun FooterSection(modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Calm Wave",
                style = MaterialTheme.typography.titleMedium,
                // A cor será herdada do contentColor do Surface (onPrimary)
            )

            Text(
                text = "© ${Calendar.getInstance().get(Calendar.YEAR)} Todos os direitos reservados.",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
                // A cor será herdada
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Política de Privacidade",
                    style = MaterialTheme.typography.labelLarge,

                    modifier = Modifier.clickable {
                        // uriHandler.openUri("https://seusite.com/privacidade")
                    }
                )
                Text(
                    text = "Termos de Uso",
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.clickable {
                        // uriHandler.openUri("https://seusite.com/termos")
                    }
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* uriHandler.openUri("https://twitter.com/seuusuario") */ }) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Compartilhar",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
                IconButton(onClick = { /* uriHandler.openUri("https://linkedin.com/in/seuusuario") */ }) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Mais Informações",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }

            Text(
                text = "Feito com ❤️ usando Jetpack Compose",
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 380)
@Composable
fun StyledFooterSectionPreview() {
    CalmwavelandingTheme {
        FooterSection()
    }
}





