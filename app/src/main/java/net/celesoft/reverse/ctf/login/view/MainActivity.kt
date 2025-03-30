package net.celesoft.reverse.ctf.login.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import net.celesoft.reverse.ctf.R
import net.celesoft.reverse.ctf.login.viewmodel.MainScreenViewModel
import net.celesoft.reverse.ctf.login.viewmodel.MainViewModel
import net.celesoft.reverse.ctf.profile.view.ProfileActivity
import net.celesoft.reverse.ctf.login.service.FakeLoginService
import net.celesoft.reverse.ctf.ui.theme.ReverseCTFTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel = MainScreenViewModel(FakeLoginService())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    private fun initView() {
        enableEdgeToEdge()
        setContent {
            ReverseCTFTheme {
                if (viewModel.hasCredentials.value) openProfileActivity()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 30.dp)
                        .background(Color.Gray),
                    Arrangement.Center
                ) {

                    TextField(
                        value = viewModel.login.value,
                        onValueChange = viewModel::onLoginChanged,
                        label = {
                            Text(stringResource(R.string.text_log_in))
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    )
                    TextField(
                        value = viewModel.password.value,
                        onValueChange = viewModel::onPasswordChanged,
                        label = {
                            Text(stringResource(R.string.text_password))
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    )

                    if (viewModel.errorVisibility.value) {
                        Text(
                            modifier = Modifier.padding(12.dp),
                            text = stringResource(R.string.msg_invalid_credentials),
                            color = Color.Red
                        )
                    }
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp),
                        onClick = viewModel::onLogInClicked
                    ) {
                        Text(
                            text = stringResource(R.string.text_log_in)
                        )
                    }
                }
            }
        }
    }

    private fun openProfileActivity() {
        startActivity(
            Intent(this, ProfileActivity::class.java)
        )
    }
}