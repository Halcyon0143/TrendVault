package com.example.trendvault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.trendvault.ui.theme.TrendVaultTheme

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityScreen()

        }
    }
}

@Composable
fun MainActivityScreen(){
    ConstraintLayout(
        modifier = Modifier.background(Color.White)
    ) {
        val(scrollList,bottomMenu)=createRefs()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                . constrainAs(scrollList){
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }

        ){
            item{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 70.dp)
                        . padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Column(){
                        Text("Welcome Back",color = Color.Black)
                        Text("Akshat",
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Row{
                        Image(
                            painter = painterResource(id = R.drawable.search_icon),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Image(
                            painter = painterResource(id = R.drawable.bell_icon),
                            contentDescription = null
                        )
                    }
                }
            }

        }
    }
}