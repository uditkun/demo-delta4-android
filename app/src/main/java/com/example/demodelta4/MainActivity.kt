package com.example.demodelta4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demodelta4.ui.theme.DemoDelta4Theme
import com.example.demodelta4.ui.theme.delta4Colors
import com.example.demodelta4.ui.theme.delta4Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoDelta4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.delta4Colors.lightBg
                ) {
                  MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(){
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { /* ... */ }, backgroundColor = MaterialTheme.delta4Colors.primary) {
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp),modifier=Modifier.padding(10.dp,16.dp)) {
                    Icon(Icons.Default.Edit, tint = Color.White, contentDescription = "")
                    Text("Create LOTO", color = Color.White)
                }
        }
    },
        bottomBar = {
            var menuState by remember {
                mutableStateOf("home")
            }

            fun handleMenuChange(value:String){
                menuState=value
            }

            @Composable
            fun MenuItems(menuName:String,paintResource: Int){
                Column(horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.spacedBy(4.dp), modifier = Modifier.clickable { handleMenuChange(menuName) }) {
                    Icon(painter = painterResource(id = paintResource), tint = if(menuState==menuName) MaterialTheme.delta4Colors.primary else MaterialTheme.delta4Colors.grey ,contentDescription = menuName)
                    Text(menuName.replaceFirstChar{it.uppercase()}, color = if(menuState==menuName) MaterialTheme.delta4Colors.primary else MaterialTheme.delta4Colors.grey)
                }
            }

            BottomAppBar(backgroundColor = Color.White, elevation = 6.dp) {
                Row(horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.Bottom, modifier = Modifier.fillMaxWidth()){
                    MenuItems(menuName = "home", paintResource = R.drawable.home)
                    MenuItems(menuName = "activity", paintResource = R.drawable.activity)
                    MenuItems(menuName = "profile", paintResource = R.drawable.profile)
                }
            }
        }
    ) {contentPadding ->
        Column(modifier = Modifier.padding(contentPadding),verticalArrangement = Arrangement.spacedBy(16.dp)){
            Navbar()
            Text("LOTO Order", fontSize = 38.sp , modifier = Modifier.padding(16.dp,0.dp,0.dp,0.dp),style = MaterialTheme.typography.h1)
            Row{
//            Button( colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)) {
//                Text(text = "Active")
//            }
//            Button( modifier = Modifier.background(Color.Transparent)) {
//                Text(text = "Completed")
//            }
                Text("Active",Modifier.padding(16.dp,8.dp), color = MaterialTheme.delta4Colors.secondary ,style = MaterialTheme.typography.h3)
                Text("Completed",Modifier.padding(16.dp,8.dp),style = MaterialTheme.typography.h3)
            }
            Column(Modifier.padding(16.dp,0.dp)){
                var textInput by remember {
                    mutableStateOf("")
                }

                var hasFocus by remember {
                    mutableStateOf(false)
                }

                TextField(
                    textInput,
                    singleLine = true,
                    onValueChange = {newTextInput -> textInput=newTextInput},
                    textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    leadingIcon = { Icon(Icons.Default.Search, tint = MaterialTheme.delta4Colors.grey,contentDescription = "Search")},
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent),
                    placeholder = { Text("Search LOTO Order")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            shape = MaterialTheme.delta4Shapes.round16,
                            color = MaterialTheme.delta4Colors.grey
                        ).onFocusChanged { hasFocus = it.hasFocus != true }
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(16.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)){
                    OutlinedButton(onClick = { /*TODO*/ },
                        border = BorderStroke(2.dp, MaterialTheme.delta4Colors.secondary),
                        shape = MaterialTheme.delta4Shapes.round16,
                        contentPadding = PaddingValues(16.dp,8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.delta4Colors.secondary
                        )) {
                        Text("All", fontSize = 14.sp,color = MaterialTheme.delta4Colors.lightBg)
                    }
                    OutlinedButton(onClick = { /*TODO*/ },
                        border = BorderStroke(2.dp, MaterialTheme.delta4Colors.primary),
                        shape = MaterialTheme.delta4Shapes.round16,
                        contentPadding = PaddingValues(16.dp,8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent
                        )
                    ) {
                        Text("Locked", fontSize = 14.sp,color = MaterialTheme.delta4Colors.primary)
                    }
                    OutlinedButton(onClick = { /*TODO*/ },
                        border = BorderStroke(2.dp, MaterialTheme.delta4Colors.primary),
                        shape = MaterialTheme.delta4Shapes.round16,
                        contentPadding = PaddingValues(16.dp,8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent
                        )
                    ) {
                        Text("Unlocked", fontSize = 14.sp,color = MaterialTheme.delta4Colors.primary)
                    }
                }
            }
            Text("15 Orders", fontSize = 14.sp, modifier = Modifier.padding(16.dp,0.dp,0.dp,0.dp))
            LazyColumn(contentPadding = PaddingValues(16.dp,0.dp),verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(orderDetails){
                    item -> OrderCard(item)
                }
            }
        }
    }
}

@Composable
fun Navbar(){
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp, 8.dp)) {
        Image(painter = painterResource(R.drawable.logo_delta4), modifier = Modifier.size(32.dp), contentDescription = null)
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)){
            Icon(Icons.Default.Notifications, modifier = Modifier.size(24.dp), tint = MaterialTheme.delta4Colors.primary, contentDescription = stringResource(R.string.main_notification_icon))
            Icon(Icons.Default.Menu,modifier = Modifier.size(24.dp), tint = MaterialTheme.delta4Colors.primary, contentDescription = stringResource(R.string.main_menu))
        }
    }
}

data class OrderData(
    val orderName: String,
    val orderStatus: String,
    val personName: String,
    val validity: String,
    val buttonText: String,
    val actionPriority: String
)

val orderDetails= listOf(
    OrderData("Monkey Cage 1", orderStatus = "Work in Progress", personName = "Amulya Kalita, Utility", validity = "25 Jun 2023", buttonText = "Connect Lock", actionPriority = "medium"),
    OrderData("Monkey Cage 1", orderStatus = "Try Out", personName = "Amulya Kalita, Utility", validity = "25 Jun 2023", buttonText = "End Work", actionPriority = "immediate"),
    OrderData("Monkey Cage 1", orderStatus = "Try Out", personName = "Amulya Kalita, Utility", validity = "25 Jun 2023", buttonText = "End Work", actionPriority = "immediate"),
)

@Composable
fun getColor(text:String):Color{
    var color:Color=MaterialTheme.delta4Colors.body
    when(text){
        "Connect Lock" -> color=MaterialTheme.delta4Colors.primary
        "Work in Progress" -> color=MaterialTheme.delta4Colors.inProgress
        "Try Out" -> color=MaterialTheme.delta4Colors.tryOut
        "End Work" -> color=MaterialTheme.delta4Colors.warningR
        "immediate" -> color=MaterialTheme.delta4Colors.danger
        "medium" -> color=MaterialTheme.delta4Colors.warningY
    }
    return color
}

@Composable
fun OrderCard(orderDetails:OrderData){
    Surface(elevation = 2.dp, shape = MaterialTheme.delta4Shapes.round4) {
        Column(verticalArrangement = Arrangement.spacedBy(14.dp), modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
                Column{
                        Text(orderDetails.orderName, style = MaterialTheme.typography.h3)
                        OutlinedButton(onClick = {},
                            modifier= Modifier.defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
                            shape = MaterialTheme.delta4Shapes.round35,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = getColor(orderDetails.orderStatus)
                            ),
                            contentPadding = PaddingValues(8.dp,4.dp),
                            border = BorderStroke(0.dp, Color.Transparent)
                        ){
                            Text(orderDetails.orderStatus, fontSize = 12.sp)
                        }
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)){
                        Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.spacedBy(4.dp)){
                            Icon(Icons.Outlined.Person, modifier = Modifier.size(14.dp),tint = MaterialTheme.delta4Colors.iconColor, contentDescription = "Person")
                            Text(orderDetails.personName)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.spacedBy(4.dp)){
                            Icon(painter = painterResource(R.drawable.calendar_month),modifier = Modifier.size(14.dp), tint = MaterialTheme.delta4Colors.iconColor, contentDescription = "Exp date")
                            Text("Valid till ${orderDetails.validity}")
                        }
                    }
                }
                Icon(Icons.Default.MoreVert, tint = MaterialTheme.delta4Colors.primary, contentDescription = "options")
            }
            Column(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.spacedBy(4.dp)){
                    Icon(Icons.Default.Info, modifier = Modifier.size(14.dp),tint = getColor(orderDetails.actionPriority), contentDescription = "info")
                    Text("You are the last person in the order", fontStyle = FontStyle.Italic, color = if(getColor(orderDetails.actionPriority)==MaterialTheme.delta4Colors.danger) getColor(text = "") else getColor(orderDetails.actionPriority))
                }
                OutlinedButton(onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.delta4Shapes.round4,
                    border = BorderStroke(2.dp, getColor(orderDetails.buttonText)),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent
                    )
                ) {
                    Text(orderDetails.buttonText, fontSize = 14.sp, color = getColor(orderDetails.buttonText))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DemoDelta4Theme {
      MainScreen()
    }
}