package {{ cookiecutter.package }}.models

data class Response(val data: Any?, val status: String = "success", val errors: List<ErrorDetail> = emptyList())
