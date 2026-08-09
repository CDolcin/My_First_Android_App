
package com.example.my_first_android_app
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_first_android_app.ui.theme.My_First_Android_AppTheme

private val categories = listOf(
    "Government",
    "Self-Finance",
    "In-Service"
)

private val programmes = listOf(
    "BE Architecture",
    "BE Civil",
    "BE Electrical",
    "BE Electronics and Communication",
    "BE Engineering Geology",
    "BE Instrumentation and Control",
    "BE Information Technology",
    "BE Mechanical",
    "BE Software Engineering"
)

private val bloodGroups = listOf(
    "A+",
    "A-",
    "B+",
    "B-",
    "AB+",
    "AB-",
    "O+",
    "O-"
)

private val semesters = listOf(
    "AS (Autumn Semester)",
    "SS (Spring Semester)"
)

private val years = listOf(
    "Year 1",
    "Year 2",
    "Year 3",
    "Year 4",
    "Year 5"
)

private fun categoryColor(category: String): Color {
    return when (category) {
        "Self-Finance" -> Color(0xFFFFF3C4)
        "In-Service" -> Color(0xFFFBE0EA)
        else -> Color(0xFFEDEBFB)
    }
}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            My_First_Android_AppTheme {
                SemesterRegistrationScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SemesterRegistrationScreen() {

    var selectedCategory by remember { mutableStateOf(categories[0]) }
    var date by remember { mutableStateOf("09/08/2026") }

    var studentName by remember { mutableStateOf("") }
    var studentEmail by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }

    var programme by remember { mutableStateOf(programmes[0]) }
    var bloodGroup by remember { mutableStateOf(bloodGroups[0]) }
    var semester by remember { mutableStateOf(semesters[0]) }
    var year by remember { mutableStateOf(years[0]) }

    var registerForBackPaper by remember { mutableStateOf(false) }
    var moduleCode by remember { mutableStateOf("") }
    var moduleName by remember { mutableStateOf("") }

    var parentName by remember { mutableStateOf("") }
    var parentEmail by remember { mutableStateOf("") }
    var parentResidence by remember { mutableStateOf("") }

    val themeColor = categoryColor(selectedCategory)

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Semester Registration",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF3F3D9E),
                    titleContentColor = Color.White
                )
            )
        },

        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Button(
                    onClick = {},
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Submit")
                }

                OutlinedButton(
                    onClick = {
                        studentName = ""
                        studentEmail = ""
                        phoneNumber = ""
                        dob = ""

                        programme = programmes[0]
                        bloodGroup = bloodGroups[0]
                        semester = semesters[0]
                        year = years[0]

                        registerForBackPaper = false
                        moduleCode = ""
                        moduleName = ""

                        parentName = ""
                        parentEmail = ""
                        parentResidence = ""
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Reset")
                }

                OutlinedButton(
                    onClick = {},
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Cancel")
                }
            }
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),

            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                label = {
                    Text("Date")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Registration Category",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = Color(0xFF3F3D9E)
            )

            SingleChoiceSegmentedButtonRow(
                modifier = Modifier.fillMaxWidth()
            ) {

                categories.forEachIndexed { index, category ->

                    SegmentedButton(
                        selected = selectedCategory == category,
                        onClick = {
                            selectedCategory = category
                        },
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = categories.size
                        )
                    ) {
                        Text(category)
                    }
                }
            }

            Surface(
                color = themeColor,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    Text(
                        text = "Student Information",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF3F3D9E)
                    )

                    OutlinedTextField(
                        value = studentName,
                        onValueChange = { studentName = it },
                        label = {
                            Text("Student Name")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = studentEmail,
                        onValueChange = { studentEmail = it },
                        label = {
                            Text("Student Email")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        label = {
                            Text("Phone Number")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = dob,
                        onValueChange = { dob = it },
                        label = {
                            Text("Date of Birth (DD/MM/YYYY)")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    DropdownField(
                        label = "Programme",
                        selected = programme,
                        options = programmes,
                        onSelected = { programme = it }
                    )

                    DropdownField(
                        label = "Blood Group",
                        selected = bloodGroup,
                        options = bloodGroups,
                        onSelected = { bloodGroup = it }
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        Box(
                            modifier = Modifier.weight(1f)
                        ) {
                            DropdownField(
                                label = "Semester",
                                selected = semester,
                                options = semesters,
                                onSelected = { semester = it }
                            )
                        }

                        Box(
                            modifier = Modifier.weight(1f)
                        ) {
                            DropdownField(
                                label = "Year",
                                selected = year,
                                options = years,
                                onSelected = { year = it }
                            )
                        }
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Checkbox(
                            checked = registerForBackPaper,
                            onCheckedChange = {
                                registerForBackPaper = it
                            }
                        )

                        Text("Register for Back Paper")
                    }

                    if (registerForBackPaper) {

                        OutlinedTextField(
                            value = moduleCode,
                            onValueChange = { moduleCode = it },
                            label = {
                                Text("Module Code")
                            },
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = moduleName,
                            onValueChange = { moduleName = it },
                            label = {
                                Text("Module Name")
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Parent / Guardian Information",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF3F3D9E)
                    )

                    OutlinedTextField(
                        value = parentName,
                        onValueChange = { parentName = it },
                        label = {
                            Text("Parent's Name")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = parentEmail,
                        onValueChange = { parentEmail = it },
                        label = {
                            Text("Parent's Email")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = parentResidence,
                        onValueChange = { parentResidence = it },
                        label = {
                            Text("Parent's Residence")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DropdownField(
    label: String,
    selected: String,
    options: List<String>,
    onSelected: (String) -> Unit
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {

        OutlinedTextField(
            value = selected,
            onValueChange = {},
            readOnly = true,
            label = {
                Text(label)
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {

            options.forEach { option ->

                DropdownMenuItem(
                    text = {
                        Text(option)
                    },
                    onClick = {
                        onSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

