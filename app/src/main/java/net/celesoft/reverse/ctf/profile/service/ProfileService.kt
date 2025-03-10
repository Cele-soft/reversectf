package net.celesoft.reverse.ctf.profile.service

import net.celesoft.reverse.ctf.profile.model.Profile

interface ProfileService {

    fun getProfile(): Profile
}