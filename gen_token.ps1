$pair = "admin:admin"
$bytes = [System.Text.Encoding]::UTF8.GetBytes($pair)
$base64 = [System.Convert]::ToBase64String($bytes)
try {
    $res = Invoke-RestMethod -Uri "http://localhost:9000/api/user_tokens/generate" -Method Post -Headers @{ Authorization = "Basic $base64" } -Body @{ name = "scanner-token-1" }
    Write-Output "TOKEN: $($res.token)"
} catch {
    Write-Output "TOKEN_ERROR: $($_.Exception.Message)"
}
