<?php

use Illuminate\Http\Request;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});



//#############################################################################################################################################

//---------------------------------  VOIR UNE OU PLUSIEURS ANNONCES ---------------------------------

Route::get('/allannonces', 'PostsController@getAnnonces')->name('allannonces');
Route::get('/annonce/{id}', 'PostsController@getAnnonce')->where('id', '[0-9]+');

//--------------------------------- AJOUTER UNE ANNONCE ---------------------------------

Route::post('/annonce/addannonce', 'PostsController@addannonce');

//--------------------------------- SUPPRIMER UNE ANNONCE ---------------------------------

Route::delete('/annonce/deleteannonce/{id}', 'PostsController@deleteannonce')->where('id', '[0-9]+');

//--------------------------------- UPDATE DE L'ANNONCE ---------------------------------

Route::post('/annonce/{id}/updatetitle', 'PostsController@updatetitle');
Route::post('/annonce/{id}/updatedescription', 'PostsController@updatedescription');
Route::post('/annonce/{id}/updateprice', 'PostsController@updateprice');
Route::post('/annonce/{id}/updatephonenumber', 'PostsController@updatephonenumber');

//#############################################################################################################################################

//--------------------------------- VOIR UN OU PLUSIEURS UTILISATEURS ---------------------------------

Route::get('/user/{id}', 'UserController@getUserById')->where('id', '[0-9]+');
Route::get('/user/allusers', 'UserController@getAllUser');

Route::post('/login', 'Auth\LoginController@login');
Route::post('/register', 'Auth\RegisterController@register');

