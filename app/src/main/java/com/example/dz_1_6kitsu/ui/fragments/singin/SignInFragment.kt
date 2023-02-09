package com.example.dz_1_6kitsu.ui.fragments.singin

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz_1_6kitsu.R
import com.example.dz_1_6kitsu.base.BaseFragment
import com.example.dz_1_6kitsu.data.locale.preferences.UserPreferencesData
import com.example.dz_1_6kitsu.data.models.auth.AuthModel
import com.example.dz_1_6kitsu.databinding.FragmentSignInBinding
import com.example.dz_1_6kitsu.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment :
    BaseFragment<FragmentSignInBinding, SignInViewModel>(R.layout.fragment_sign_in) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    override val binding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels()

    override fun setupSubscribes() = with(binding) {

        binding.signInBottom.setOnClickListener {
            val email = enterName.text.toString()
            val password = enterPassword.text.toString()
            val authModel = AuthModel("password", email, password)

            viewModel.postUserData(authModel).subscribe(
                onError = {
                    Log.e("TAG", "setupSubscribes: $it")
                },
                onSuccess = {
                    toast("$it")
                    if (it != null) {
                        userPreferencesData.apply {
                            isAuthorized = true
                            accessToken = it.accessToken
                            refreshToken = it.refreshToken
                        }
                        requireActivity().findNavController(R.id.fragment_container)
                            .navigate(R.id.action_singinFlowFragment_to_homeFlowFragment)
                    }
                }
            )
        }
    }
}