package com.example.studying.data

// Backend emulation
class AppDetailsApi {
    fun get(): AppDetailsDto {
        return AppDetailsDto(
            "fa2e31b8-1234-4cf7-9914-108a170a1b01",
            "QuickNote",
            "QuickSoft Inc.",
            "Производительность",
            3,
            8.2,
            "https://fastly.picsum.photos/id/237/200/200.jpg?hmac=zHUGikXUDyLCCmvyww1izLK3R3k8oRYBRiTizZEdyfI",
            listOf(
                "https://fastly.picsum.photos/id/2/200/200.jpg?hmac=isSWZUpv7D1D156XcADPOCZlfCG9mmvb8OlXFdvLdK0",
                "https://fastly.picsum.photos/id/3/200/200.jpg?hmac=N5yYUNYl5gOUcaMmTtnNNtx839TN2qaNM4SaXhQl65U",
                "https://fastly.picsum.photos/id/4/200/200.jpg?hmac=ozRrjh7SMobdmKcOU0f5sWYszFW9Or1c90qeq7uqtuw",
                "https://fastly.picsum.photos/id/5/200/200.jpg?hmac=oN9VtXdJYLSFssji8vCr48JaI-e5Zi4eH9GAiYBB_Ig",
                "https://fastly.picsum.photos/id/6/200/200.jpg?hmac=g4Q9Vcu5Ohm8Rwap3b6HSIxUfIALZ6BasESHhw7VjLE",
            ),
            "QuickNote — практичное приложение для хранения, организации и быстрой фиксации идей."
        )
    }
}