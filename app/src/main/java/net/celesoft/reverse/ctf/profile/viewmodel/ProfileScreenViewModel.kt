package net.celesoft.reverse.ctf.profile.viewmodel

import net.celesoft.reverse.ctf.profile.model.Profile
import net.celesoft.reverse.ctf.profile.service.FakeProfileService
import net.celesoft.reverse.ctf.profile.service.ProfileService

class ProfileScreenViewModel : ProfileViewModel {

    private val profileService: ProfileService = FakeProfileService()

    override fun getProfile(): Profile =
        profileService.getProfile()
}