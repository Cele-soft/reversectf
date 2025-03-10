package net.celesoft.reverse.ctf.profile.service

import net.celesoft.reverse.ctf.profile.model.Profile

class FakeProfileService : ProfileService {

    override fun getProfile(): Profile {
        val isPremium = checkPremiumProfileByFakeApiService()
       return Profile(
            id = "US2212",
            name = "User1984",
            email = "user1984@reveres.ctf",
            discount = if (isPremium) "50%" else "0%",
            code = if (isPremium) getPremiumCode() else ""
        )
    }
    private fun checkPremiumProfileByFakeApiService(): Boolean = getPremiumCode() != getPremiumCode()

    private fun getPremiumCode(): String =
        xorDecrypt("115, 26, 95, 88, 117, 26, 93, 68, 117, 78, 27, 89, 73, 69, 95, 68, 94", 42)

    private fun xorDecrypt(encryptedData: String, key: Int): String =
        encryptedData.split(", ")
            .map { it.toInt().xor(key).toChar() }
            .joinToString("")
}