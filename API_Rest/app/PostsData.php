<?php

namespace App;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Support\Facades\DB;

class PostsData extends Model
{
    protected $fillable = [
        'category', 'title', 'description','price','number','user_id'
    ];
}
