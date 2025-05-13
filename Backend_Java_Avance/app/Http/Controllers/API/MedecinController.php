<?php

namespace App\Http\Controllers\API;

use App\Http\Controllers\Controller;
use App\Models\Medecin;
use Exception;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Facades\Validator;

class MedecinController extends Controller
{
    public function index()
    {
        $medecins = Medecin::latest('id')->get();
        if ($medecins->isEmpty()) {
            return response()->json([
                'status' => Response::HTTP_NOT_FOUND,
                'message' => 'medoc empty'
            ], Response::HTTP_NOT_FOUND);
        } else {
            return response()->json([
                'data' => $medecins->map(function($medoc) {
                    return [
                        'id' => $medoc->id,
                        'nom' => $medoc->nom,
                        'nombre_jours' => $medoc->nombre_jours,
                        'taux_journalier' => $medoc->taux_journalier
                    ];
                }),
                'message' => 'List medoc',
                'status' => Response::HTTP_OK
            ], Response::HTTP_OK);
        }
    }

    public function store(Request $request)
    {
        $validator = Validator::make($request->all(),[
            'nom' => 'required',
            'nombre_jours' => 'required',
            'taux_journalier' => 'required',
        ]);

        if ($validator->fails()) {
            return response()->json($validator->errors());
        }

        try {
            Medecin::create([
                'nom' => $request->nom,
                'nombre_jours' => $request->nombre_jours,
                'taux_journalier' => $request->taux_journalier
            ]);

            return response()->json([
                'status' => Response::HTTP_OK,
                'message' => 'Data stored to Db'
            ], Response::HTTP_OK);
        } catch (Exception $e) {
            Log::error('Error storing data : '. $e->getMessage());

            return response()->json([
                'status' => Response::HTTP_INTERNAL_SERVER_ERROR,
                'message' => 'Failed stored to Db'
            ], Response::HTTP_INTERNAL_SERVER_ERROR);
        }
    }

    public function show($id)
    {
        $medoc = Medecin::where('id', $id)->first();

        if ($medoc) {
            return response()->json([
                'status' => Response::HTTP_OK,
                'data' => [
                    'id' => $medoc->id,
                    'nom'=> $medoc->nom,
                    'nombre_jours' => $medoc->nombre_jours,
                    'taux_journalier' => $medoc->taux_journalier
                ]
            ], Response::HTTP_OK);
        } else {
            return response()->json([
                'status' => Response::HTTP_NOT_FOUND,
                'message' => 'Medoc not found'
            ], Response::HTTP_NOT_FOUND);
        }
    }

    public function update(Request $request, $id)
    {
        $medoc = Medecin::find($id);

        if (!$medoc) {
            return response()->json([
                'status' => Response::HTTP_NOT_FOUND,
                'message' => 'Product not found'
            ], Response::HTTP_NOT_FOUND);
        }

        $validator = Validator::make($request->all(),[
            'nom' => 'required',
            'nombre_jours' => 'required',
            'taux_journalier' => 'required',
        ]);

        if ($validator->fails()) {
            return response()->json($validator->errors());
        }

        try {
            $medoc->update([
                'nom' => $request->nom,
                'nombre_jours' => $request->nombre_jours,
                'taux_journalier' => $request->taux_journalier
            ]);

            return response()->json([
                'status' => Response::HTTP_OK,
                'message' => 'Data updated'
            ], Response::HTTP_OK);
        } catch (Exception $e) {
            Log::error('Error update data : '. $e->getMessage());

            return response()->json([
                'status' => Response::HTTP_INTERNAL_SERVER_ERROR,
                'message' => 'Failed stored to Db'
            ], Response::HTTP_INTERNAL_SERVER_ERROR);
        }
    }

    public function destroy($id)
    {
        $medoc = Medecin::find($id);

        if (!$medoc) {
            return response()->json([
                'status' => Response::HTTP_NOT_FOUND,
                'message' => 'Medoc not found'
            ], Response::HTTP_NOT_FOUND);
        }

        try {
            $medoc->delete();

            return response()->json([
                'status' => Response::HTTP_OK,
                'message' => 'Data deleted'
            ], Response::HTTP_OK);

        } catch (Exception $e) {
            Log::error('Error update data : '. $e->getMessage());

            return response()->json([
                'status' => Response::HTTP_INTERNAL_SERVER_ERROR,
                'message' => 'Failed delete data'
            ], Response::HTTP_INTERNAL_SERVER_ERROR);
        }
    }
}
