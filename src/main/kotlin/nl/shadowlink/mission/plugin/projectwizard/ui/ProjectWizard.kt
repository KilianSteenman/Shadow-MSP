package nl.shadowlink.mission.plugin.projectwizard.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nl.shadowlink.mission.plugin.projectwizard.ScriptModuleType
import org.jetbrains.skija.Image.makeFromEncoded

@Composable
internal fun ProjectSetupScreen(onModuleTypeSelected: (ScriptModuleType) -> Unit) {
    Surface(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        val selectedScriptModuleType: MutableState<ScriptModuleType?> = remember { mutableStateOf(null) }

        Column {
            Row {
                ScriptModuleType.values().forEach { moduleType ->
                    ProjectTile(
                        scriptModuleType = moduleType,
                        isSelected = moduleType == selectedScriptModuleType.value
                    ) {
                        selectedScriptModuleType.value = moduleType
                        onModuleTypeSelected(moduleType)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

            selectedScriptModuleType.value?.let { type ->
                Spacer(Modifier.height(16.dp))
                Surface(
                    modifier = Modifier.fillMaxWidth()
                        .height(200.dp)
                        .border(width = 1.dp, color = Color.Gray)
                ) {
                    Text(type.description, modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
internal fun ProjectTile(scriptModuleType: ScriptModuleType, isSelected: Boolean, onClicked: () -> Unit) {
    val borderColor = when {
        isSelected -> Color.Red
        scriptModuleType.isAvailable -> Color.Black
        else -> Color.LightGray
    }

    val textColor = when {
        scriptModuleType.isAvailable -> Color.Black
        else -> Color.Gray
    }

    Box(modifier = Modifier.border(width = 1.dp, color = borderColor)
        .height(100.dp)
        .width(100.dp)
        .clickable { if (scriptModuleType.isAvailable) onClicked() }
    ) {
        Column(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
            Spacer(Modifier.weight(1f))
            Image(
                bitmap = imageFromBundledResource(javaClass, "/icons/mission_file_icon.png"),
                contentDescription = "${scriptModuleType.title} icon",
                modifier = Modifier.width(20.dp).height(20.dp).align(Alignment.CenterHorizontally),
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = scriptModuleType.type.title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = textColor,
            )
            Text(
                text = scriptModuleType.game.gameName,
                fontSize = 12.sp,
                color = textColor
            )
        }
    }
}

fun imageFromBundledResource(javaClass: Class<Any>, path: String): ImageBitmap {
    return makeFromEncoded(javaClass.getResourceAsStream(path).readBytes()).asImageBitmap()
}