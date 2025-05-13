<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

Route::prefix('medecin')->group(function () {
    Route::get('', [App\Http\Controllers\API\MedecinController::class,'index']);
    Route::post('', [App\Http\Controllers\API\MedecinController::class,'store']);
    Route::get('{id}', [App\Http\Controllers\API\MedecinController::class,'show']);
    Route::put('{id}', [App\Http\Controllers\API\MedecinController::class,'update']);
    Route::delete('{id}', [App\Http\Controllers\API\MedecinController::class,'destroy']);
});