 package br.senai.sp.jandira.contatos_bb

import android.icu.text.UnicodeSet.SpanCondition
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.contatos_bb.ui.theme.ContatosBBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContatosBBTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FormularioContatos("")
                }
            }
        }
    }
}

@Composable
fun FormularioContatos(name: String, modifier: Modifier = Modifier) {
var nomeState = remember {
    mutableStateOf("")
}
    var emailState = remember {
        mutableStateOf("")
    }
    var foneState = remember {
        mutableStateOf("")
    }
    var dataNascimentoState = remember {
        mutableStateOf("")
    }
    var isAmigo = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.padding(16.dp),

    ) {
        Text(text = stringResource(id = R.string.title_new_contact),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black)

        OutlinedTextField(
            value = nomeState.value,
            onValueChange = {
                   nomeState.value = it
            },
            label = {
                Text(text = stringResource(id = R.string.contact_name))
            },
            modifier = Modifier.fillMaxWidth()

        )
        OutlinedTextField(
            value = emailState.value,
            onValueChange = {
                            emailState.value = it
            },
            label = {
                Text(text = stringResource(id = R.string.contact_mail))
            },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = foneState.value,
            onValueChange = {
                    foneState.value = it
            },
            label = {
                Text(text = stringResource(id = R.string.telephone))
            },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = dataNascimentoState.value,
            onValueChange = {
                            dataNascimentoState.value = it
            },
            label = {
                Text(text = stringResource(id = R.string.birthday_date))
            },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(checked = isAmigo.value, onCheckedChange = {

                isAmigo.value = it
            })
            Text(text = stringResource(id = R.string.is_friend))
        }
        Spacer(modifier = Modifier.padding(24.dp))

        Button(onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()) {
Text(text = stringResource(id = R.string.save))
        }





    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ContatosBBTheme {
        FormularioContatos("")
    }
}