package kr.ac.kumoh.ce.s20190757.s23w11counter

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import kr.ac.kumoh.ce.s20190757.s23w11counter.ui.theme.CounterViewModel
import kr.ac.kumoh.ce.s20190757.s23w11counter.ui.theme.S23W11CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val vm = ViewModelProvider(this)[CounterViewModel::class.java]

        super.onCreate(savedInstanceState)
        setContent {
            MyApp { // Lambda Function
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center,) {
                    Counter(vm)
                    Counter(vm)
                }
            }
        }
    }
}

@Composable
fun Counter(viewModel: CounterViewModel) {
    //var (count, setCount) = remember { mutableStateOf(0) }
    val count by viewModel.count.observeAsState(initial = 0)

    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "$count", fontSize = 70.sp,)
        Row {
            Button(modifier = Modifier
                .weight(1f),
                onClick = {
                    viewModel.onAdd()
                }) {
                Text("Increase")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(modifier = Modifier
                .weight(1f),
                onClick = {
                    viewModel.onSub()
                }) {
                Text("Decrease")
            }
        }

    }

}

@Composable
fun Clicker() {
    //var txtString = "눌러주세요";
    // var txtString by remember { mutableStateOf("눌러주세요")}
    val (txtString, setTxtString) = remember {      // 1. react의 useState와 비슷하다.
        mutableStateOf("눌러주세요")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = txtString,
            fontSize = 70.sp,
        )
        Button(modifier = Modifier
            .fillMaxWidth(),
            onClick = {
                setTxtString("눌렀습니다")
            }) {
            Text("눌러봐")
        }
    }
}
@Composable
fun MyApp(content: @Composable () -> Unit) {
    S23W11CounterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}