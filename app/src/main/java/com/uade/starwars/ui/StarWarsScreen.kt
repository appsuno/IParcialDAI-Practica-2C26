package com.uade.starwars.ui

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.uade.starwars.data.StarWarsCategory
import com.uade.starwars.data.StarWarsItem
import com.uade.starwars.data.StarWarsRepository
import com.uade.starwars.logic.DiagnosticLogger
import com.uade.starwars.logic.StarWarsLogic
import com.uade.starwars.ui.theme.StarWarsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StarWarsScreen(
    repository: StarWarsRepository = StarWarsRepository()
) {
    val context = LocalContext.current

    // Categoría actualmente seleccionada
    var categoriaSeleccionada by remember { mutableStateOf(StarWarsCategory.FILMS) }

    // Lista de elementos de la categoría seleccionada
    val todosLosElementos = remember(categoriaSeleccionada) {
        repository.getItemsByCategory(categoriaSeleccionada)
    }

    // =========================================================================
    // ERROR 1: Estado no recordado en TextField (se reinicia en cada recomposición)
    // =========================================================================
    var busqueda = ""

    // =========================================================================
    // ERROR 2: Uso de colección mutable ordinaria en lugar de mutableStateListOf
    // =========================================================================
    val favoritos = mutableListOf<Int>()

    // =========================================================================
    // ERROR 5: Cálculo de porcentaje con división entera truncada a cero
    // =========================================================================
    val porcentajeProgreso = StarWarsLogic.calcularPorcentajeProgreso(
        favoritos = favoritos.size,
        total = todosLosElementos.size
    )

    // =========================================================================
    // ERROR 6: Cálculo de restantes con resta invertida
    // =========================================================================
    val faltantes = StarWarsLogic.calcularRestantes(
        total = todosLosElementos.size,
        favoritos = favoritos.size
    )

    // =========================================================================
    // ERROR 3: Invocación de parseo de ID sin control de excepciones/null safety
    // ERROR 7: Filtro con operador lógico && (AND) en lugar de || (OR)
    // =========================================================================
    val listaFiltrada = if (busqueda.isNotBlank()) {
        val idFiltro = try {
            StarWarsLogic.parsearIdBuscado(busqueda)
        } catch (e: Exception) {
            null
        }

        todosLosElementos.filter { item ->
            item.name.contains(busqueda, ignoreCase = true) && (idFiltro != null && item.id == idFiltro)
        }
    } else {
        todosLosElementos
    }

    Scaffold(
        topBar = {
            TopAppBar(
                // =========================================================================
                // ERROR 10 (Parte A): Texto hardcodeado en lugar de stringResource(...)
                // =========================================================================
                title = {
                    Text(
                        text = "Holocrón Star Wars: Galaxia",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
            val diagnosticLogger = DiagnosticLogger()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Fila de Chips para seleccionar categoría (Películas, Personajes, Planetas, Especies)
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(StarWarsCategory.values()) { categoria ->
                    FilterChip(
                        selected = categoria == categoriaSeleccionada,
                        onClick = { categoriaSeleccionada = categoria },
                        label = { Text(categoria.displayName) }
                    )
                }
            }

            // Tarjeta de Métricas y Estadísticas del Holocrón
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Marcados en Holocrón: ${favoritos.size} de ${todosLosElementos.size}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Faltan explorar: $faltantes registros",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "Progreso de exploración: $porcentajeProgreso%",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    // =========================================================================
                    // ERROR 10 (Parte B): Intent sin especificar el tipo MIME (type = "text/plain")
                    // =========================================================================
                    Button(
                        onClick = {
                            val sendIntent = Intent(Intent.ACTION_SEND).apply {
                                putExtra(
                                    Intent.EXTRA_TEXT,
                                    "¡He explorado ${favoritos.size} elementos de ${categoriaSeleccionada.displayName} en el Holocrón Star Wars!"
                                )
                            }
                            val diagnosticLogger = DiagnosticLogger()
                            context.startActivity(sendIntent)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Transmitir reporte a la Rebelión")
                    }
                }
            }

            // Buscador por nombre o ID
            OutlinedTextField(
                value = busqueda,
                onValueChange = { nuevoTexto ->
                    busqueda = nuevoTexto
                },
                label = { Text("Buscar por nombre o número de ID…") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            // Listado de elementos de la categoría seleccionada
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listaFiltrada) { item ->
                    val esFavorito = favoritos.contains(item.id)

                    // ERROR 9: Si es película, clasifica su era usando la función con rangos superpuestos
                    val infoAdicional = if (item.category == StarWarsCategory.FILMS) {
                        "${item.subtitle} • ${StarWarsLogic.clasificarEraPelicula(item.id)}"
                    } else {
                        item.subtitle
                    }

                    // =========================================================================
                    // ERROR 4 (Parte A): Padding aplicado ANTES de clickable en el Card
                    // =========================================================================
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp, vertical = 2.dp)
                            .clickable { },
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            // =========================================================================
                            // ERROR 4 (Parte B): Background aplicado ANTES de clip(CircleShape)
                            // =========================================================================
                            AsyncImage(
                                model = item.imageUrl,
                                contentDescription = item.name,
                                modifier = Modifier
                                    .size(64.dp)
                                    .background(Color.DarkGray)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = item.name,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = infoAdicional,
                                    fontSize = 13.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = item.detail,
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            // =========================================================================
                            // ERROR 8: Al quitar de favoritos se ejecuta removeAt(0)
                            // =========================================================================
                            Button(
                                onClick = {
                                    if (esFavorito) {
                                        if (favoritos.isNotEmpty()) {
                                            favoritos.removeAt(0)
                                        }
                                    } else {
                                        favoritos.add(item.id)
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (esFavorito) Color(0xFFD32F2F) else MaterialTheme.colorScheme.primary
                                )
                            ) {
                                Text(if (esFavorito) "Quitar" else "Marcar")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StarWarsScreenPreview() {
    StarWarsTheme {
        StarWarsScreen()
    }
}
