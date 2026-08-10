$pair = "admin:admin"
$bytes = [System.Text.Encoding]::UTF8.GetBytes($pair)
$base64 = [System.Convert]::ToBase64String($bytes)
try {
    $res = Invoke-RestMethod -Uri "http://localhost:9000/api/users/current" -Headers @{ Authorization = "Basic $base64" }
    Write-Output "LOGGED_IN_USER: $($res.login)"
} catch {
    Write-Output "AUTH_ERROR: $($_.Exception.Message)"
}
