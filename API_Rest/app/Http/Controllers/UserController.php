<?php

namespace App\Http\Controllers;

use Illuminate\Foundation\Bus\DispatchesJobs;
use Illuminate\routing\Controller as BaseController;
use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Foundation\Auth\Access\AuthorizesRequests;
use Illuminate\Http\request;
use Illuminate\Support\Facades\DB;

use App\User;
use Auth;


class UserController extends Controller
{
    use AuthorizesRequests, DispatchesJobs, ValidatesRequests;

    function getUserById($id)
    {
        $annonce = DB::table('users')
            ->find($id);
        return response()->json($annonce);
    }

    function getAllUser()
    {
        $annonce = DB::table('users')
            ->get();
        return response()->json($annonce);
    }



    public function login(){
        if(Auth::attempt(['email' => request('email'), 'password' => request('password')])){
            $user = Auth::user();
            $success['token'] =  $user->createToken('usertoken')-> accessToken;
            $token = $success['token'];
            return redirect()->route('dashboard',[ 'token' => $token]);
        }
        else{
            return response()->json("email ou mot de passe incorrect", 401);
        }
    }
}
