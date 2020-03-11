<?php

namespace App\Http\Controllers;

use App\PostsData;
use Illuminate\Foundation\Bus\DispatchesJobs;
use Illuminate\routing\Controller as BaseController;
use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Foundation\Auth\Access\AuthorizesRequests;
use Illuminate\Http\request;
use Illuminate\Support\Facades\DB;


class PostsController extends Controller
{
    use AuthorizesRequests, DispatchesJobs, ValidatesRequests;

    function getAnnonce($id)
    {
        $annonce = DB::table('annonces')
        ->find($id);
        return response()->json($annonce);
    }

    function getAnnonces()
    {
        $annonce = DB::table('annonces')
        ->get();
        return response()->json($annonce);
    }

    public function addannonce(Request $request)
    {
        $request->validate([
            'category' => 'required|string',
            'title' => 'required|string',
            'description' => 'required|string',
            'price' => 'required|int',
            'number' => 'required|string',
            'user_id' => 'required|int',
        ]);

        if(empty($result = DB::table('annonces')
            ->where("id",$request->input("id"))
            ->get()
            ->toArray()
        ))
        {
            $res = DB::table('annonces')
                ->insert([
                    'category' => $request->category,
                    'title'=>$request->title,
                    'description'=> $request->description,
                    'price' => $request->price,
                    'number'=>$request->number,
                    'user_id'=>$request->user_id,
                ]);
        }
        return response()->json('Now add');
    }


    public function deleteannonce($id)
    {
        DB::table('annonces')->delete($id);
    }

    public function updatetitle(Request $request, $id)
    {
        $result = DB::table('annonces')
            ->where("id",$id)
            ->get()
            ->toArray();

        $res = DB::table('annonces')
            ->where([
                ['id', $id],
                ['user_id', $request->input("user_id")]
            ])
            ->update([
                'title' => $request->input("title")
            ]);
        return response()->json($res);
    }

    public function updatedescription(Request $request, $id)
    {
        $result = DB::table('annonces')
            ->where("id",$id)
            ->get()
            ->toArray();

        $res = DB::table('annonces')
            ->where([
                ['id', $id],
                ['user_id', $request->input("user_id")]
            ])
            ->update([
                'description' => $request->input("description")
            ]);
        return response()->json($res);
    }

    public function updateprice(Request $request, $id)
    {
        $result = DB::table('annonces')
            ->where("id",$id)
            ->get()
            ->toArray();

        $res = DB::table('annonces')
            ->where([
                ['id', $id],
                ['user_id', $request->input("user_id")]
            ])
            ->update([
                'price' => $request->input("price")
            ]);
        return response()->json($res);
    }

    public function updatephonenumber(Request $request, $id)
    {
        $result = DB::table('annonces')
            ->where("id",$id)
            ->get()
            ->toArray();

        $res = DB::table('annonces')
            ->where([
                ['id', $id],
                ['user_id', $request->input("user_id")]
            ])
            ->update([
                'number' => $request->input("number")
            ]);
        return response()->json($res);
    }
}
